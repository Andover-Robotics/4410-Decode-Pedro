package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.geometry.Pose;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.ivy.groups.Groups;
import static com.pedropathing.ivy.commands.Commands.*;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.teleop.subsystems.Bot;

@Autonomous(name = "Nine Ball")
public class NineBall extends AbstractAuto {
    private Bot bot;

    public static Pose STARTING_POSE = new Pose(72.000, 72.000, Math.toRadians(0));

    @Override
    protected Pose getStartingPose() {
        return STARTING_POSE;
    }

    public void initPaths() {

    }

    @Override
    protected void initAuto() {
        Bot.instance = null;
        bot = Bot.getInstance(this);

        initPaths();

        Command autoCommand = Groups.sequential(
                instant(() -> bot.enableShooter()),
                waitMs(1000),
                new RRToPedroCommand(bot.indexer.shootRapidFire())
        );

        Scheduler.schedule(
                Groups.parallel(
                        new RRToPedroCommand(bot.actionPeriodic()),
                        autoCommand
                )
        );
    }
}
