public class NBody{
	public static String imageToDraw = "starfield.jpg";

	public static double readRadius(String filename){
		In in = new In(filename);
		int count = 0;
		double radius = 0;
		while(!in.isEmpty()){
			count++;
			radius = in.readDouble();
			if(count == 2){	
				return radius;
			}
		}
		return -1;
	}
	
	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int count = 0;
		int num = in.readInt();
		Planet[] planets = new Planet[num];
		double[] temp = new double[5];
		double radius = in.readDouble();
		while(!in.isEmpty()){
			temp[0] = in.readDouble();
			temp[1] = in.readDouble();
			temp[2] = in.readDouble();
			temp[3] = in.readDouble();
			temp[4] = in.readDouble();
			String name = in.readString();
			System.out.println(name);
			Planet planet = new Planet(temp[0], temp[1], temp[2], temp[3], temp[4], name);

			planets[count] = planet;
			if(count == num - 1){
				break;
			}
			count++;		
		}
		return planets;
	}

	public static void main(String[] args){
		double time = 0;
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		int numPlanets = planets.length;
		double[] xForce = new double[numPlanets];
		double[] yForce = new double[numPlanets];
		drawThree(radius);
		while(time < T){
			time += dt;

			System.out.println(time);
			for(int i = 0; i < numPlanets; i++){
				xForce[i] = planets[i].calcNetForceExertedByX(planets);
				yForce[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for(int i = 0; i < numPlanets; i++){
				planets[i].update(dt, xForce[i], yForce[i]);
			}

			for(int i = 0; i < planets.length; i++){
				planets[i].draw();
			}

		}
		
	}

	public static void drawThree(double radius){

		StdDraw.clear();
		StdDraw.setScale(-radius / 2, 1.5 * radius);
		StdDraw.picture(0, 100, imageToDraw);

		StdDraw.show(2000);	

	}

}