package org.usfirst.frc.team5542.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *Single command to collect, organize, and execute the autonomous code.
 */
public class AutoGamePlan extends CommandGroup {
	public  AutoGamePlan() {  
		addSequential(new AutoCanLift());
		//addSequential(new AutoTurnRight());
		//addSequential(new AutoMoveUp());
		addSequential(new AutoToteAlign());
		addSequential(new AutoToteGrab());
		addSequential(new AutoTurnLeft());
		addSequential(new AutoZone());
	}
// Add Commands here:
// e.g. addSequential(new Command1());
//      addSequential(new Command2());
// these will run in order.

// To run multiple commands at the same time,
// use addParallel()
// e.g. addParallel(new Command1());
//      addSequential(new Command2());
// Command1 and Command2 will run in parallel.

// A command group will require all of the subsystems that each member
// would require.
// e.g. if Command1 requires chassis, and Command2 requires arm,
// a CommandGroup containing them would require both the chassis and the
// arm.
}
