package org.firstinspires.ftc.teamcode.auto;

import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.ivy.groups.Groups;
import com.pedropathing.ivy.pedro.PedroCommands;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Square Auto")
public class SquareAuto extends AbstractAuto {
    private PathChain line1;
    private PathChain line2;
    private PathChain line3;
    private PathChain line4;

    public static Pose STARTING_POSE = new Pose(72.000, 72.000, Math.toRadians(0));
    public static Pose FIRST_CORNER = new Pose(72.000, 72.000);
    public static Pose SECOND_CORNER = new Pose(24.000, 72.000);
    public static Pose THIRD_CORNER = new Pose(24.000, 120.000);
    public static Pose FOURTH_CORNER = new Pose(72.000, 120.000);;

    @Override
    protected Pose getStartingPose() {
        return STARTING_POSE;
    }

    public void initPaths() {
        line1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                FIRST_CORNER,
                                SECOND_CORNER
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();

        line2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                SECOND_CORNER,
                                THIRD_CORNER
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();

        line3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                THIRD_CORNER,
                                FOURTH_CORNER
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();

        line4 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                FOURTH_CORNER,
                                FIRST_CORNER
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }

    @Override
    protected void initAuto() {
        initPaths();

        Scheduler.schedule(
                Groups.sequential(
                        PedroCommands.follow(follower, line1),
                        PedroCommands.follow(follower, line2),
                        PedroCommands.follow(follower, line3),
                        PedroCommands.follow(follower, line4)
                )
        );
    }
}
