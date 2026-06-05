package org.firstinspires.ftc.teamcode.auto;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.ivy.groups.Groups;
import com.pedropathing.ivy.pedro.PedroCommands;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Square Auto")
public class SquareAuto extends OpMode {
    private Follower follower;

    PathChain line1;
    PathChain line2;
    PathChain line3;
    PathChain line4;

    public void constructPaths() {
        line1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(72.000, 72.000),
                                new Pose(24.000, 72.000)
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
                        PedroCommands.follow(follower, line1),
                        PedroCommands.follow(follower, line2),
                        PedroCommands.follow(follower, line3),
                        PedroCommands.follow(follower, line4)
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
