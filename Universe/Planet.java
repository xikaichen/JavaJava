class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dX = xxPos - p.xxPos;
		double dY = yyPos - p.yyPos; 
		double rSqure = dX * dX + dY * dY;
		return Math.sqrt(rSqure);
	}

	public double calcForceExertedBy(Planet p){
		double G = 6.67 * Math.pow(10,-11);
		return G * mass * p.mass / (calcDistance(p) * calcDistance(p));
	}

	public double calcForceExertedByX(Planet p){
		return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] planets){
		double netForce = 0;
		for(int i = 0; i < planets.length; i++){
			if(this.equals(planets[i])){
				continue;
			}
			netForce += calcForceExertedByX(planets[i]);
		}
		return netForce;
	}

	public double calcNetForceExertedByY(Planet[] planets){
		double netForce = 0;
		for(int i = 0; i < planets.length; i++){
			if(this.equals(planets[i])){
				continue;
			}
			netForce += calcForceExertedByY(planets[i]);
		}
		return netForce;
	}

	public void update(double dt, double fX, double fY){
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel += dt * aX;
		yyVel += dt * aY;
		xxPos += dt * xxVel;
		yyPos += dt * yyVel;
	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, imgFileName);
		StdDraw.show(10);	
	}

}