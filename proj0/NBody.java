public class NBody{
	public static double readRadius(String s){
		In in = new In(s);
		int N = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int N = in.readInt();
		double R = in.readDouble();
		Planet[] planets = new Planet[N];
		for(int i = 0;i < N;i += 1){
			double xp = in.readDouble();
			double yp = in.readDouble();
			double xv = in.readDouble();
			double yv = in.readDouble();
			double m = in.readDouble();
			String name = in.readString();
			Planet p = new Planet(xp,yp,xv,yv,m,name);
			planets[i] = p;
		}
		return planets;
	}
	/*public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = readPlanets(filename);
		double R = readRadius(filename);
		StdDraw.setScale(-R, R);
		StdDraw.clear();
		StdDraw.picture(0,0,"../images/starfield.jpg");
		for(int i = 0;i < planets.length;i += 1){
			planets[i].draw();
		}
		enableDoubleBuffering();
	}*/
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = readPlanets(filename);
		double R = readRadius(filename);
		StdDraw.setScale(-R, R);
		StdDraw.clear();
		StdDraw.picture(0,0,"../images/starfield.jpg");
		for(int i = 0;i < planets.length;i += 1){
			planets[i].draw();
		}
		StdDraw.enableDoubleBuffering();
	}
}