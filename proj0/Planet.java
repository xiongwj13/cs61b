public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
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
	};
	public double calcDistance(Planet p){
		return Math.sqrt((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + (this.yyPos - p.yyPos)*(this.yyPos - p.yyPos));
	}
	public double calcForceExertedBy(Planet p){
		double G = 6.67E-11;
        return G*this.mass*p.mass/(this.calcDistance(p)*this.calcDistance(p));
	}
	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}
	public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] ps){
        double res = 0;
        for (int i = 0;i < ps.length;i += 1){
        	if (!this.equals(ps[i])) {
        		res += this.calcForceExertedByX(ps[i]);
        	}
        }
        return res;
	} 
	public double calcNetForceExertedByY(Planet[] ps){
        double res = 0;
        for (int i = 0;i < ps.length;i += 1){
        	if (!this.equals(ps[i])) {
        		res += this.calcForceExertedByY(ps[i]);
        	}
        }
        return res;
	} 
	public void update(double dt,double fX,double fY){
		double aX = fX/this.mass;
		double aY = fY/this.mass;
		this.xxVel = this.xxVel + aX*dt;
		this.yyVel = this.yyVel + aY*dt;
		this.xxPos = this.xxPos + this.xxVel*dt;
		this.yyPos = this.yyPos + this.yyVel*dt;
	}
	public void draw(){
		StdDraw.picture(this.xxPos,this.yyPos,"../image/" + this.imgFileName);
	}
}