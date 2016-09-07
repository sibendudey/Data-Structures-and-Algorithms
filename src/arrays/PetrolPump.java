package arrays;


class Pump	{
	int petrol;
	int nextPumpDistance;
	Pump( int petrol , int nextPumpDistance)	{
		this.petrol = petrol;
		this.nextPumpDistance = nextPumpDistance;
	}
}
public class PetrolPump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pump pump[] = new Pump[4];
		pump[0] = new Pump(4,6);
		pump[1] = new Pump(6,5);
		pump[2] = new Pump(7,3);
		pump[3] = new Pump(4,5);
		System.out.println(findStartPoint( pump));
	}

	private static int findStartPoint(Pump[] pump) {
		// TODO Auto-generated method stub
		int delta = 0;
		int totalDelta = 0;
		int startPos = -1;
		for ( int i = 0; i < pump.length ; i++)	{
			int temp = pump[i].petrol - pump[i].nextPumpDistance;
			if ( delta < 0)	{
				startPos = i;
				delta = temp;
			}
			else	{
				delta += temp;
			}
			totalDelta += temp;
		}
		
		return totalDelta > 0 ? startPos : -1;
	}

}
