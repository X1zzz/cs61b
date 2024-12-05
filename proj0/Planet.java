import examples.StdDraw;

public class Planet {
    public double xxPos;    // Its current x position
    public double yyPos;    // Its current y position
    public double xxVel;    // Its current velocity in the x direction
    public double yyVel;    // Its current velocity in the y direction
    public double mass;     // Its mass
    // The name of the file that corresponds to the image that depicts the planet
    // (for example, jupiter.gif)
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    // copy constructor
    public Planet(Planet p)
    {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }


    public double calcDistance(Planet p2) {
        double dx = p2.xxPos - this.xxPos;
        double dy = p2.yyPos - this.yyPos;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double calcForceExertedBy(Planet p2) {
        double G=6.67e-11;
        double r=calcDistance(p2);         // 注意不要写成double r=calcDistance(Planet p2);
        return G*this.mass*p2.mass/(r*r);
    }

    public double calcForceExertedByX(Planet p2) {
        double F =calcForceExertedBy(p2);
        double dx = p2.xxPos-this.xxPos;
        double r=calcDistance(p2);
        return F*dx/r;

    }

    public double calcForceExertedByY(Planet p2) {
        double F =calcForceExertedBy(p2);
        double dy = p2.yyPos-this.yyPos;
        double r=calcDistance(p2);
        return F*dy/r;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double Fx_net=0;
        for (Planet p: planets)
        {
            if (p == this) {continue;}
            double Fx_p=calcForceExertedByX(p);
            Fx_net += Fx_p;
        }
        return Fx_net;
    }


    public double calcNetForceExertedByY(Planet[] planets) {
        double Fy_net=0;
        for (Planet p: planets)
        {
            if(p == this) {continue;}
            double Fy_p=calcForceExertedByY(p);
            Fy_net += Fy_p;
        }
        return Fy_net;
    }


    public void update(double t, double xForce, double yForce) {
        double xAcc=xForce/this.mass;
        double yAcc=yForce/this.mass;
        xxVel += t*xAcc;
        yyVel += t*yAcc;
        xxPos += t*xxVel;
        yyPos += t*yyVel;

    }

    public void draw() {
        String wholeImgFileName ="./images/" +imgFileName;
        StdDraw.picture(xxPos, yyPos, wholeImgFileName);
    }

}










