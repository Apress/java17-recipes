package org.java17recipes.chapter08.recipe08_13;

import java.lang.ProcessBuilder;
import java.lang.Process;
import java.time.Instant;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
public class Recipe08_13 {
  public static void printProcessDetails(ProcessHandle currentProcess){
    //Get the instance of process info
    ProcessHandle.Info currentProcessInfo = currentProcess.info();
    if ( currentProcessInfo.command().orElse("").equals("")){
      return;
    }
    //Get the process id
    System.out.println("Process id: " + currentProcess.pid());
    //Get the command pathname of the process
    System.out.println("Command: " + currentProcessInfo.command().orElse(""));
    //Get the arguments of the process
    String[] arguments = currentProcessInfo.arguments().orElse(new String[]{});
    if ( arguments.length != 0){
      System.out.print("Arguments: ");
      for(String arg : arguments){
        System.out.print(arg + " ");
      }
      System.out.println();
    }
    //Get the start time of the process
    System.out.println("Started at: " + currentProcessInfo.startInstant().orElse(Instant.now()).toString());
    //Get the time the process ran for
    System.out.println("Ran for: " + currentProcessInfo.totalCpuDuration().orElse(Duration.ofMillis(0)).toMillis() + "ms");
    //Get the owner of the process
    System.out.println("Owner: " + currentProcessInfo.user().orElse(""));
  }
  public static void main(String[] args){
    ProcessHandle current = ProcessHandle.current();
    ProcessHandle.Info currentInfo = current.info();
    System.out.println("Command Line Process: " + currentInfo.commandLine());
    System.out.println("Process User: " + currentInfo.user());
    System.out.println("Process Start Time: " + currentInfo.startInstant());
    System.out.println("PID: " + current.pid());
    ProcessBuilder pb = new ProcessBuilder("ls");
    try {
    Process process = pb.start();
    System.out.println(process);
    process.children()
    .forEach((p) ->{
     System.out.println(p);
   });
      ProcessHandle pHandle = process.toHandle();
     System.out.println("Parent of Process: " + pHandle.parent());
    } catch (java.io.IOException e){
      System.out.println(e);
    }
  }
}

