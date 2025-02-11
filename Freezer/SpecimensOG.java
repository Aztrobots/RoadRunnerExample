package org.firstinspires.ftc.teamcode.Freezer;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.MecanumDrive;


@Autonomous
public class  SpecimensOG extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Pose2d beginPose = new Pose2d(10 , -65, 270);
        Hardware robot = new Hardware(this);
        RobotActions actions = new RobotActions(robot);
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

        robot.init();

        ////////////////////////// P R E L O A D ///////////////////////////////////////////////

        TrajectoryActionBuilder PreLoadS = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(3,-41.3 ), Math.toRadians(270));
        beginPose = new Pose2d(3,-41.3 ,Math.toRadians(270));

        ///////////////////////// C A R R Y ////////////////////////////////////////////////////

        TrajectoryActionBuilder TakeFirstSample = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(41.8,-60.4 ), Math.toRadians(75));
        beginPose = new Pose2d(41.8,-60,Math.toRadians(75));

        TrajectoryActionBuilder LeaveFirstSample =  drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(37,-48.5 ), Math.toRadians(290));
        beginPose = new Pose2d(37,-48.5,Math.toRadians(290));

        TrajectoryActionBuilder TakeSecondSample = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(50,-61 ), Math.toRadians(77));
        beginPose = new Pose2d(50,-61,Math.toRadians(77));

        TrajectoryActionBuilder LeaveSecondSample = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(38,-54 ), Math.toRadians(290));
        beginPose = new Pose2d(38,-38,Math.toRadians(290));



        //////////////////////// S P E C I M E N S /////////////////////////////////////////////

        TrajectoryActionBuilder TakeFirstSpecimen = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(36,-60.3), Math.toRadians(92));
        beginPose = new Pose2d(36 ,-60.3 ,Math.toRadians(92));


        TrajectoryActionBuilder LeaveFirstSpecimen = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(0,-42), Math.toRadians(270));
        beginPose = new Pose2d(0,-42,Math.toRadians(270));


        TrajectoryActionBuilder TakeSecondSpecimen = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(35,-61.5), Math.toRadians(92));
        beginPose = new Pose2d(35,-61.5,Math.toRadians(92));


        TrajectoryActionBuilder LeaveSecondSpecimen = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(-3,-41.2), Math.toRadians(270));
        beginPose = new Pose2d(-3  ,-41.2 ,Math.toRadians(270));

        TrajectoryActionBuilder TakeThirdSpecimen = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(35,-62.8 ), Math.toRadians(92));
        beginPose = new Pose2d(35,-62.8 ,Math.toRadians(92));


        TrajectoryActionBuilder LeaveThirdSpecimen = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(-2,-42), Math.toRadians(270));
        beginPose = new Pose2d(-2,-42 ,Math.toRadians(270 ));

        TrajectoryActionBuilder Park = drive.actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(23,-54 ), Math.toRadians(315));


        waitForStart();

        Actions.runBlocking(
                new SequentialAction(
                  new ParallelAction(
                    

                  )

            )
        );
    }
}

