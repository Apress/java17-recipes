package org.java17recipes.chapter02.recipe02_12;

	import java.time.Duration;
	import java.util.Optional;

	public class OSInformationExample {
	    public static void main (String[] args){
	        listProcesses();
	        detailListProcesses();
	        detailListProcessUsers();
	    }
	    
	    public static void listProcesses(){
	        ProcessHandle.allProcesses()
	                .forEach(System.out::println);
	    }
	    
	    public static void detailListProcesses(){
	        ProcessHandle.allProcesses()
	                .forEach(h->System.out.println(formattedProcess(h)));
	    }
	    
	    public static void detailListProcessUsers(){
	        ProcessHandle.allProcesses()
	                .forEach(h->System.out.println(listOsUser(h)));
	    }

	    public static ProcessHandle.Info obtainInfo(ProcessHandle handle){
	        return handle.info();
	    }
	    
	    public static String formattedProcess(ProcessHandle handle){
	        long pid = handle.pid();
	        boolean alive = handle.isAlive();
	        Optional<Duration> cpuDuration = handle.info().totalCpuDuration();
	        Optional<String> handleName = handle.info().command();
	        return pid + " " + alive + " " + handleName + ":"+ cpuDuration;
	     }
	    
	    public static String listOsUser(ProcessHandle handle){
	        ProcessHandle.Info procInfo = handle.info();
	        return handle.pid() + ": " +procInfo.user();
	    }
	}