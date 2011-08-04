<?php
declare(ticks = 1);
function signal_handler($signal) {
    switch ($signal) {
      case SIGTERM:
        echo "Caught SIGTERM\n";
		exec("/usr/bin/killall -9 php");
		break;

      case SIGQUIT:
        echo "Caught SIGQUIT\n";
		exec("/usr/bin/killall -9 php");
        break;

      case SIGINT:
        echo "Caught SIGINT\n";
		exec("/usr/bin/killall -9 php");
        break;
    }
  }

exec("/usr/bin/php -q random.php > /dev/null 2>&1 &");
exec("/usr/bin/php -q filter.php > /dev/null 2>&1 &");
while(1)
{
	for($i=0;$i<10;$i++)
	if(file_exists("$i.txt"))
		{
		$lines = count(file("$i.txt"));
		echo "There are $lines lines in $i.txt \n";
		}
	else 
		echo "The file $i.txt does not exist \n";
	echo "\n";
	sleep(1);
	pcntl_signal(SIGTERM, "signal_handler");
	pcntl_signal(SIGQUIT, "signal_handler");
	pcntl_signal(SIGINT, "signal_handler");
}

?>