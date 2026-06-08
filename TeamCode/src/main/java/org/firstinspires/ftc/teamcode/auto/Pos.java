package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.pedropathing.geometry.Pose;

@Config
public class Pos {
    // SOME VARIABLES
    public static final double GATE_INTAKE_ANGLE = Math.toRadians(57);

    // INITIAL
    public static Pose initialFarBluePose = new Pose(-63, 9, Math.toRadians(0));
    public static Pose initialCloseBluePose = new Pose(62, 41, Math.toRadians(180));
    public static Pose initialFarRedPose = transformRed(initialFarBluePose);
    public static Pose initialCloseRedPose = transformRed(initialCloseBluePose);

    // INTAKE

    public static Pose blueMidIntake = new Pose(-11, 34.5, Math.toRadians(90));
    public static double intakeDisp = 23;

    public static Pose gate = new Pose(-11, 67, GATE_INTAKE_ANGLE);

    public static Pose gateSideOpenHeadOn = new Pose(1, 62, Math.toRadians(90));
    public static Pose gateSideOpenHeadOnBack = new Pose(1, gateSideOpenHeadOn.getY()- 20, Math.toRadians(90));

    public static Pose blueCloseIntake = new Pose(11, 32, Math.toRadians(90));
    public static double closeIntake = 15;

    public static Pose blueFarIntakeFarAuto = new Pose(-44, 63, Math.toRadians(90));
    public static Pose blueFarIntakeCloseAuto = new Pose(-33, 35, Math.toRadians(90));

    public static Pose pushPark = new Pose(-58,  20, Math.toRadians(90));

    public static Pose blueHpIntake = new Pose(-44, 68, Math.toRadians(179));
    public static Pose redHpIntake = new Pose(-44, 62, Math.toRadians(179));
    public static Pose blueHpSideIntake = new Pose(-61, 60, Math.toRadians(90));

    public static Pose blueSecretTunnel = new Pose(-36, 62, Math.toRadians(35));
    public static Pose blueHpCycle = new Pose(-62, 55, Math.toRadians(90));

    // SHOOTING (Vectors, as we do not care about robot orientation here)
    public static Pose firstShoot = new Pose(18, 20);
    public static Pose closeShoot = new Pose(4, 17);
    public static Pose closeShootPark = new Pose(30, 18);
    public static Pose closeGateCycleShoot = new Pose(4, 19);
    public static Pose closePark = new Pose(-1, 21);
    public static Pose farShoot = new Pose(-53, 19);
    public static Pose farPark = new Pose(-40, 24);

    public static Pose transformRed(Pose pose) {
        return new Pose(pose.getX(), -pose.getY(), -pose.getHeading());
    }
}