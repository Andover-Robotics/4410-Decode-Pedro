package org.firstinspires.ftc.teamcode.auto;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.ivy.groups.Groups;
import com.pedropathing.ivy.pedro.PedroCommands;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Bezier Auto")
public class BezierAuto extends OpMode {
    private Follower follower;

    PathChain Spline1;
    PathChain line2;
    PathChain line3;
    PathChain line4;

    public void constructPaths() {
        Spline1 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(72.000, 72.000),
                                new Pose(47.000, 72.000),
                                new Pose(41.869, 99.640)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(180))
                .addPath(
                        new BezierCurve(
                                new Pose(41.869, 99.640),
                                new Pose(52.757, 121.188),
                                new Pose(72.000, 94.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .addPath(
                        new BezierLine(
                                new Pose(72.000, 94.000),
                                new Pose(72.000, 72.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();



        line2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(24.000, 72.000),
                                new Pose(24.000, 120.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        line3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(24.000, 120.000),
                                new Pose(72.000, 120.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        line4 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(72.000, 120.000),
                                new Pose(72.000, 72.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();
    }

    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);
        follower.setPose(new Pose(72, 72));

        Scheduler.reset();

        constructPaths();

        Scheduler.schedule(
                Groups.sequential(
                        PedroCommands.follow(follower, Spline1)
                )
        );
    }

    @Override
    public void loop() {
        Scheduler.execute();
        follower.update();
    }

    @Override
    public void stop() {
        Scheduler.reset();
    }
}
