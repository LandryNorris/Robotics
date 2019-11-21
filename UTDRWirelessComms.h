/*
UT Dallas Robotics Wireless Communication Library v1
Written by Joey Hines (joey.ahines@gmail.com)

This library allows for parsing packets from serial in the style of 
"~{type}{id}{data}\LF". It is to be used with a ESP8266 and the UTD
Robotics wireless controller.
  
*/
#include "Arduino.h"
#include <SoftwareSerial.h>
#ifndef UTDRWirelessComms_h
#define UTDRWirelessComms_h

class UTDRWirelessComms {
	private:
	//Default input size and packet size
	int MaxInSize = 10;
	int packetSize = 3;
	
	SoftwareSerial * serial;
	
	public:
	
	void getCommandPacket(int[]);
	
	UTDRWirelessComms(SoftwareSerial *);
	UTDRWirelessComms(SoftwareSerial *, int, int);

};

#endif