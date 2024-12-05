//import examples.In;
//import examples.StdDraw;

public class NBody {


    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);

        in.readInt();
        double planetRadius = in.readDouble();
        return planetRadius;
    }

    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int total= in.readInt();
        Planet[] allPlanets = new Planet[total];
        in.readDouble();

        int i = 0;
        while(!in.isEmpty() && i <= total-1) {         // i <= 4是为了处理，读取完所有的行星之后，不要把最后的文字读进来
            Planet p;
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            p = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
            allPlanets[i] = p;
            i++;
        }

        return allPlanets;
    }

    public static void main(String[] args) {     // String[] args，原来存储的是命令行参数
        // 获取命令行参数 157788000.0 25000.0 data/planets.txt
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double planetRadius = NBody.readRadius(filename);
        Planet[] allPlanets = NBody.readPlanets(filename);
        int planetNum = allPlanets.length;

        // 画图
        StdDraw.setScale(-planetRadius, planetRadius);  // 图片的尺度不能太小，不然其它的星球画不出来
        StdDraw.clear();
        StdDraw.picture(0, 0, "./images/starfield.jpg");

        for (Planet p : allPlanets) {
            p.draw();
        }

        StdDraw.enableDoubleBuffering();
        int currTime =0;

        while (currTime < T){
            double[] xForces = new double[planetNum];
            double[] yForces = new double[planetNum];
            for(int i=0; i <= planetNum - 1; i++)
            {
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
                allPlanets[i].update(dt,xForces[i],yForces[i]);
            }


            StdDraw.clear();
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for(int i=0; i <= planetNum - 1; i++)
            {
                allPlanets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            currTime += dt;
        }

        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", planetRadius);
        for (int i = 0; i <allPlanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                    allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }






    }
}
