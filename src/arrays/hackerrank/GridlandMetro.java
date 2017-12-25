package arrays.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class GridlandMetro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int noOfRows = sc.nextInt();
        int noOfCols = sc.nextInt();
        int noOfTracks = sc.nextInt();

        Set<Track> tracks = new HashSet<>();

        for (int i = 1; i <= noOfTracks; i++)
            tracks.add(new Track(sc.nextInt(), sc.nextInt(), sc.nextInt()));

        long sum1 = tracks.stream()
                .collect(Collectors.groupingBy(track -> track.row1))
                .entrySet()
                .stream()
                .mapToLong(entry ->
                {
                    List<Track> mergedTracks = new ArrayList<>();
                    entry.getValue().stream()
                            .sorted( (track1, track2) -> {
                                if (track1.col1 <= track2.col1)
                                    return -1;
                                else return 1;
                            })
                            .forEach(track ->
                            {
                                if (mergedTracks.size() == 0) {
                                    mergedTracks.add(track);
                                    return;
                                }

                                Track lastTrack = mergedTracks.get(mergedTracks.size() - 1);
                                if ( track.col1 >= lastTrack.col1
                                        && lastTrack.col2 >= track.col1
                                        && lastTrack.col2 < track.col2 ) {

                                    Track newMergedTrack = new Track(lastTrack.row1, lastTrack.col1, track.col2);
                                    mergedTracks.remove(lastTrack);
                                    mergedTracks.add(newMergedTrack);
                                }
                                else if (track.col1 > lastTrack.col2) mergedTracks.add(track);
                            });

                    return noOfCols -
                            (mergedTracks
                                    .stream()
                                    .mapToLong(mergedTrack -> mergedTrack.col2 - mergedTrack.col1 + 1)
                                    .sum());

                }).sum();

        long sum = noOfCols * (long)(noOfRows - tracks.stream().collect(() -> new HashSet<Integer>(),
                (hs, track) -> hs.add(track.row1),
                (hs1, hs2) -> hs1.addAll(hs2)).size());

        System.out.println(sum + sum1);

    }

    static class Occupancy {
        int noOfCols;
        Map<Integer, Integer> occupencyMap;

        public Occupancy(int noOfCols) {
            this.noOfCols = noOfCols;
            occupencyMap = new HashMap();
        }

        public void fillOccupency(Track track) {
            for (int i = track.col1; i <= track.col2; i++)
                occupencyMap.putIfAbsent(i, 1);
        }

        public long unFilledOccupency() {
            return noOfCols - occupencyMap.size();
        }
    }

    static class Track {
        int row1;
        int col1;
        int col2;

        public Track(int row1, int col1, int col2) {
            this.row1 = row1;
            this.col1 = col1;
            this.col2 = col2;
        }
    }
}
