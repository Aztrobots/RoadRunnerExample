package org.firstinspires.ftc.teamcode.Freezer;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    private LinearOpMode myOpMode = null;

    // Motors
    public DcMotor MI = null;
    public DcMotor MD = null;
    public DcMotor FL = null;
    public DcMotor FR = null;
    public DcMotor BR = null;
    public DcMotor BL = null;
    public DcMotor Extension = null;
    public DcMotor Intake = null;

    // Servos
    public Servo TorI = null;
    public Servo Outtake = null;
    public Servo TorO = null;

    // Init values
    public static final double TorI_INIT = 0.165;
    public static final double Outtake_INIT = 0.16;
    public static final double TorO_INIT = 0;

    public Hardware(LinearOpMode opMode) {
        this.myOpMode = opMode;
    }

    public void init() {
        // Initialize motors
        MD = myOpMode.hardwareMap.get(DcMotor.class, "MD");
        MI = myOpMode.hardwareMap.get(DcMotor.class, "MI");
        Extension = myOpMode.hardwareMap.get(DcMotor.class, "Extension");
        Intake = myOpMode.hardwareMap.get(DcMotor.class, "Intake");


        Extension.setDirection(DcMotor.Direction.REVERSE);

        // Encoders


        // ZeroPowerBehavior
        MD.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MI.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Extension.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Initialize servos
        TorI = myOpMode.hardwareMap.get(Servo.class, "TorI");
        Outtake = myOpMode.hardwareMap.get(Servo.class, "Outtake");
        TorO = myOpMode.hardwareMap.get(Servo.class, "TorO");


        // Init servos
        Outtake.setPosition(Outtake_INIT);
        TorO.setPosition(TorO_INIT);
        TorI.setPosition(TorI_INIT);


        // Telemetry
        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }
}