<!--  
/*
 * Program:		A clock that spells out time with fuzziness. For example, 2:43 would show as It is almost fifteen to three.
 * Coder:		Rahul Ramesh
 * Email:		msg4rahul@gmail.com
 * Website:		http://theCoder.in/
 * Phone:		+91-9447786285
 *
 * Date:	 	18 June 2011
 * Demo:		http://thecoder.in/codejam/clock/
 */
 -->

<style type="text/css">
* { font-family:"arial"; font-size: 30px;}
</style>
<?php
	/*
	 * Sentence Compostion:
	 	* Part 1:	It's
	 	* Part 2:	[nearly(before 30mins),almost(after 30mins)]/[precisely,exactly,now]/[about,around,after]
	 	* Part 3:	<value in minutes>
	 	* Part 4:	[past/to/null]
	 	* Part 5:	<value in hours>
	 	* Part 6:	[null/O'clock]
	 * Morning/Noon/Afternoon/Evening/Night
	 * Greetings:
	 	* Morning/Afternoon/Evening
	 * When to use terms:
	 	* T-2 to T-1 mins 	= nearly/almost
	 	* T-0 mins			= Precisely/exactly/now
	 	* T+1 to T+2 mins	= about/around/after
	 	* 
	 	* x:1  to x:30 = nearly; 	past;
	 	* x:31 to x:59 = almost;	to;
	*/


	/*
	 *Testing purpose only: 
	 	*If $debugging = true, it displays FUZZY time with one minute intervals, (60*24 times) in the same page to check for errors;
	 */
	$debugging				= false;							
	$test_cases				= 1;							//One time execution during deployment
	if ($debugging == true)
	{
		$test_cases			= 1440;							//FUZZY time for a whole day with 1-minute intervals on a single page
	}
	
	$time_stamp 			= time();						//Number of seconds since Jan 1 1970
	for($i = 0; $i < $test_cases; $i++)
	{
		$hour 				= gmdate("H",$time_stamp) + 5;	//Converting GMT to Indian time by adding with 5 hours
		$minute 			= gmdate("i",$time_stamp) + 30;	//Converting GMT to Indian time by adding with 30 minutes
		$second				= gmdate("s",$time_stamp);
		$greeting			= "";
		
		if ($second >= 60)
		{
			$second-= 60;									//Enforcing standards for seconds after conversion
			$minute++;
		}
		if ($minute >= 60)
		{
			$minute-= 60;									//Enforcing standards for seconds after conversion
			$hour++;
		}
		if ($hour >= 24)
		{
			$hour-= 24;										//Enforcing standards for seconds after conversion
		}
		if ($hour >= 12 && $hour <= 18 )
		{
			$greeting = "Good Afternoon!";
		}
		else if ($hour >= 19 && $hour <= 22 )
		{
			$greeting = "Good Evening";
		}
		else if ($hour >= 5 && $hour <= 11)
		{
			$greeting = "Good morning"; 
		}
		if ($hour >= 12)									
		{
			$hour-=12;										//Rounding off to 12 Hours
		}
		
		$relative = array									//Candidates for the Part 2 of the sentence
		(
			"t_minus" 	=> array							
			(
				"nearly",
				"almost"
			),
			"t" 		=> array 
			(
				"precisely",
				"exactly",
				"now"
			),
			"t_plus"	=> array
			(
				"about",
				"around",
				"after"
			)
		);
		$hours = array										//Candidates for Part 5
		(
			
			"twelve",
			"one",
			"two",
			"three",
			"four",
			"five",
			"six",
			"seven",
			"eight",
			"nine",
			"ten",
			"eleven",
		);
		$minutes = array									//Candidates for Part 3
		(
			0  => "",
			5  => "five minutes",
			10 => "ten minutes",
			15 => "quarter",
			20 => "twenty minutes",
			25 => "twenty five minutes",
			30 => "half",
			35 => "twenty five minutes",
			40 => "twenty minutes",
			45 => "quarter",
			50 => "ten minutes",
			55 => "five minutes",	
			60 => ""
		);
		$sentence = array									//Sentence Composition
		(
			0  => "It's",
			"relative" => "",
			"minutes" => "",
			"pt" => "",
			"hours" => "",
			"oclock" => "",
		);
		$mod5 = fmod($minute, 5); 
//Choosing word for Part 2 and 3 of the sentence		
		if ($mod5>=3 && $mod5<=4)
		{
			if ($minute >= 1 and $minute <= 30)
			{
				$sentence["relative"] = $relative["t_minus"][0];	//nearly
			} 
			else if ($minute >= 31 and $minute <= 59)
			{
				$sentence["relative"] = $relative["t_minus"][1];	//almost
			}
			$sentence["minutes"] = $minutes[$minute + (5-$mod5)]; 
		}
		else if ($mod5>=1 && $mod5<=2)
		{
			
		if ($minute >= 1 and $minute <= 30)
			{
				$sentence["relative"] = $relative["t_plus"][rand(0,2)];	//randomly from [about or around or after]
			} 
			else if ($minute >= 31 and $minute <= 59)
			{
				$sentence["relative"] = $relative["t_plus"][rand(0,1)];	//randomly from [about or around]
			}
			$sentence["minutes"] = $minutes[$minute - ($mod5)];
		}
		else
		{
			$sentence["relative"] = $relative["t"][rand(0,2)];		//randomly from [precisely or exactly or now]
			$sentence["minutes"] = $minutes[$minute];
		}
//Choosing word for Part 4 of the sentence		
		if($minute >= 3 && $minute <= 32)
		{
			$sentence["pt"] = "past";
			$sentence["oclock"] = ".";
		} 
		else if($minute >= 33 && $minute <= 57)
		{
			$sentence["pt"] = "to";
			$sentence["oclock"] = ".";
		}
//Choosing word for Part 6 of the sentence	
		else if($minute == 0 || $minute >= 58 || $minute <= 2)
		{
			$sentence["oclock"] = "O'clock .";
		}
		
//Choosing hour (in words) for Part 5 of the sentence
		if ($minute >= 33)
		{
			$sentence["hours"] = $hours[$hour+1];
		}
		else 
		{
			$sentence["hours"] = $hours[$hour];	
		}
//Adding 0 as prefix		
		if ($hour < 10)
		{
			$hour = "0".$hour;
		}
		if ($minute < 10)
		{
			$minute = "0".$minute;
		}
		echo $greeting."</br>";
//Displaying Actual time
		echo "</br>".$hour.":".$minute."</br>";
//Displaying FUZZY Time			
		foreach ($sentence as $word)
		{
			echo $word;
			if ($word != "")
			{
				echo " ";
			}
		}
		
		echo "</br>";
//For Debugging purpose only		
		$time_stamp+=60;
	}
	
?> 