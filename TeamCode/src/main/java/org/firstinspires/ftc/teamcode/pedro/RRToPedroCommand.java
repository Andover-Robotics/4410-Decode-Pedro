package org.firstinspires.ftc.teamcode.pedro;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.behaviors.BlockedBehavior;
import com.pedropathing.ivy.behaviors.ConflictBehavior;
import com.pedropathing.ivy.behaviors.EndCondition;
import com.pedropathing.ivy.behaviors.InterruptedBehavior;

import java.util.Set;

public class RRToPedroCommand implements Command {
    private Action rrAction;
    private boolean done;

    public RRToPedroCommand(Action rrAction) {
        this.rrAction = rrAction;
    }

    @Override
    public void start() {

    }

    @Override
    public void execute() {
        done = rrAction.run(new TelemetryPacket());
    }

    @Override
    public boolean done() {
        return done;
    }

    @Override
    public void end(EndCondition endCondition) {

    }

    @Override
    public Set<Object> requirements() {
        return Set.of();
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public InterruptedBehavior interruptedBehavior() {
        return InterruptedBehavior.END;
    }

    @Override
    public BlockedBehavior blockedBehavior() {
        return BlockedBehavior.CANCEL;
    }

    @Override
    public ConflictBehavior conflictBehavior() {
        return ConflictBehavior.OVERRIDE;
    }
}
