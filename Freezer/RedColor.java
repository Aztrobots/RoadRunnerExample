package org.firstinspires.ftc.teamcode.Freezer;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import android.graphics.Color;


@TeleOp
public class RedColor extends LinearOpMode {

    private ColorSensor Sensor;

    @Override
    public void runOpMode() {

        Sensor = hardwareMap.get(ColorSensor.class, "Sensor");


        waitForStart();


        while (opModeIsActive()) {

            int red = Sensor.red();
            int green = Sensor.green();
            int blue = Sensor.blue();
            int alpha = Sensor.alpha();
            int color = 0;

            boolean Red = false;
            boolean Blue = false;
            boolean Yellow = false;
            boolean Green = false;

            // RGB a HSV
            float[] hsv = new float[3];
            Color.RGBToHSV((int) (red * 255.0 / alpha),
                    (int) (green * 255.0 / alpha),
                    (int) (blue * 255.0 / alpha),
                    hsv);


            if (red > blue && red > green) {
                telemetry.addData("Freezer gots", "red");
                Red = true;
                color = 1;
            } else if (blue > red && blue > green) {
                telemetry.addData("Freezer gots", "blue");
                Blue = true;
                color = 2;
            }
             else if (green > 1000 && red > 1000 && blue > 1000) {
                telemetry.addData("Freezer gots", "yellow");
                Yellow = true;
                color = 3;
            }

            telemetry.update();
        }
    }
}