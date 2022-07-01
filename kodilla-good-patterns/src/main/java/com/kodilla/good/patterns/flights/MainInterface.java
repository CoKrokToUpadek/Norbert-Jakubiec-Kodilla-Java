package com.kodilla.good.patterns.flights;

public class MainInterface {
    public static void main(String[] args) {
        FlyPathsDB db=new FlyPathsDB();
        Airport lubin=new Airport("Lubin");
        Airport gdansk=new Airport("Gdansk");
        Airport poznan_lawica=new Airport("Poznan-Lawica");
        Airport szczecin_goleniow=new Airport("Szczecin-Goleniow");
        Airport katowice_pyrzowice=new Airport("Katowice-Pyrzowice");

        FlyPaths lubinFlyPaths=new FlyPaths(lubin);
        lubinFlyPaths.addNewFlyPathAsStartingPoint(szczecin_goleniow);
        lubinFlyPaths.addNewFlyPathAsStartingPoint(poznan_lawica,szczecin_goleniow);
        lubinFlyPaths.addNewFlyPathAsEndPoint(gdansk,poznan_lawica);
        lubinFlyPaths.addNewFlyPathAsTransitPoint(katowice_pyrzowice,lubin,poznan_lawica);

        FlyPaths szczecinFlyPaths=new FlyPaths(szczecin_goleniow);
        szczecinFlyPaths.addNewFlyPathAsStartingPoint(gdansk);
        szczecinFlyPaths.addNewFlyPathAsEndPoint(gdansk);
        szczecinFlyPaths.addNewFlyPathAsTransitPoint(poznan_lawica,szczecin_goleniow,gdansk);

        db.addAirportToDB(lubin,lubinFlyPaths);
        db.addAirportToDB(szczecin_goleniow,szczecinFlyPaths);

        db.printPaths(lubin);


    }
}
