package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.pedropathing.ivy.Scheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public abstract class AbstractAuto extends OpMode {
    protected Follower follower;

    protected abstract Pose getStartingPose();

    protected abstract void initAuto();

    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);
        follower.setPose(getStartingPose());

        Scheduler.reset();
        initAuto();
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
