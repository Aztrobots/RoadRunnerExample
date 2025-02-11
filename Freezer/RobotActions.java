package org.firstinspires.ftc.teamcode.Freezer;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.*;

@Config
public class RobotActions {
    private final Hardware robot;

    public static int ExtensionV = 1400;
    public static double ArmUpV = 0.815;

    public RobotActions(Hardware robot) {
        this.robot = robot;
    }

    //                       L I N E A R  S L I D E S                      //


    public class MisumisDown implements Action {
        private boolean initialized = false;

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialized) {
                initialized = true;
            }
            robot.MD.setTargetPosition(0);
            robot.MI.setTargetPosition(0);
            robot.MI.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.MD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.MI.setPower(1);
            robot.MD.setPower(1);
            return false;
        }
    }
    public Action MisumisDown() {return this.new MisumisDown();}

    public class AbrirGarra implements Action {
        private boolean initialized = false;

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialized) {
                initialized = true;
            }
            robot.Outtake.setPosition(0.5);
            return false;
        }
    }
    public Action AbrirGarra() {return this.new AbrirGarra();}


}







