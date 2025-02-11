package org.firstinspires.ftc.teamcode.Freezer;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp
public class TeleOperate extends LinearOpMode {

    Hardware robot = new Hardware(this);
    private static final int MAX_EXTENSION_POSITION = 1650;
    private static final int MIN_EXTENSION_POSITION = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init();

        waitForStart();

        while (opModeIsActive()) {

            // DriveTrain
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rotation = gamepad1.right_stick_x;

            double FLPower = y + x + rotation;
            double FRPower = y - x - rotation;
            double BLPower = y - x + rotation;
            double BRPower = y + x - rotation;

            robot.FL.setPower(FLPower);
            robot.FR.setPower(FRPower);
            robot.BL.setPower(BLPower);
            robot.BR.setPower(BRPower);

            // Intake
            robot.Intake.setPower(gamepad2.right_trigger);
            if (gamepad2.left_trigger>0) {
                robot.Intake.setPower(-gamepad2.left_trigger);
            }

            // TorI
            if (gamepad2.dpad_up) {
                robot.TorI.setPosition(0.165);
            }
            if (gamepad2.dpad_down) {
                robot.TorI.setPosition(0.45);
            }

            // Outtake
            if (gamepad2.x) {
                robot.Outtake.setPosition(0.175);
            }
            if (gamepad2.y) {
                robot.Outtake.setPosition(0.042);
            }

            // Samples
            if (gamepad2.right_bumper) {
                robot.Outtake.setPosition(0.042);
                robot.TorI.setPosition(0.45);
                sleep(50);
                robot.TorO.setPosition(0.715);
            }

            if (gamepad2.left_bumper) {
                robot.TorO.setPosition(0);
                robot.Outtake.setPosition(0.16);
            }

            // Specimens


            // Linear Slides
            if (gamepad1.y) {
                robot.MI.setTargetPosition(2100);
                robot.MD.setTargetPosition(2100);
                robot.MD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.MI.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.MD.setPower(1);
                robot.MI.setPower(1);
            } else if (gamepad1.a) {
                robot.TorO.setPosition(0);
                robot.Outtake.setPosition(0.175);
                sleep(50);
                robot.MI.setTargetPosition(0);
                robot.MD.setTargetPosition(0);
                robot.MD.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.MI.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.MD.setPower(1);
                robot.MI.setPower(1);
            }

            // Extension
            if (gamepad1.right_trigger > 0) {
                int currentPosition = robot.Extension.getCurrentPosition();
                int increment = (int) (300 * gamepad1.right_trigger);
                int newPosition = Math.min(currentPosition + increment, MAX_EXTENSION_POSITION);
                robot.Extension.setTargetPosition(newPosition);
                robot.Extension.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.Extension.setPower(0.95);
            } else if (gamepad1.left_trigger > 0) {
                int currentPosition = robot.Extension.getCurrentPosition();
                int decrement = (int) (300 * gamepad1.left_trigger);
                int newPosition = Math.max(currentPosition - decrement, MIN_EXTENSION_POSITION);
                robot.Extension.setTargetPosition(newPosition);
                robot.Extension.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.Extension.setPower(0.95);
            }

            if (gamepad2.start) {
                robot.TorI.setPosition(0.165);
                robot.Extension.setTargetPosition(0);
                robot.Extension.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.Extension.setPower(0.95);
            }
            // Telemetry to monitor positions
            telemetry.addData("Extension Position", robot.Extension.getCurrentPosition());
            telemetry.addData("MI Position", robot.MI.getCurrentPosition());
            telemetry.addData("MD Position", robot.MD.getCurrentPosition());
            telemetry.update();
        }
    }
}

