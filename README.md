WebMonitor
==========

Monitors n number of websites, each website for a user defined s number of seconds for availability. In the event of a website failure it will log the failure alert to a monitoring.log file. To run this file you must supply the arguments of the configuration file which is "monitoring.conf". I will supply the file I used. This config file is just a list of websites, and then the time in seconds that you want that website to be checked. This was a school project for me. Looking back I would have made a couple changes. First I would have nested the WebTimer class into the WebMonitor class instead of giving it it’s own discreet file. Secondly I would have used a HashMap instead of an Array for the keyArray in the WebMonitor class.
