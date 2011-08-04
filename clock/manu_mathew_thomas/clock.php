<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>clock</title>
	<meta name="generator" content="TextMate http://macromates.com/">
	<meta name="author" content="Manu Mathew Thomas">
	<script src="https://ajax.googleapis.com/ajax/libs/prototype/1.7.0.0/prototype.js"></script>
	<!-- Date: 2011-06-17 -->
	<style>
	body{
		background:black;
		color:white;
		text-align:center;
		text-indent:left;
		font-weight:bold;
		font-size:50px;

	}
	</style>

</head>
<body>

<script type="text/javascript"> new Ajax.PeriodicalUpdater('clock', 'clock.php', {   method: 'get',   frequency:30 });</script><!--prototype function for updating every 30 second-->


<?php

function numberToWord($hour) //Function to convert hour in digit to words
{


	if(date(i)>=30)
	{
		if($hour==1)

			return "TWO";
		else if($hour==2)
			return "THREE";
		else if($hour==3)
			return "FOUR";
		else if($hour==4)
			return "FIVE";
		else if($hour==5)
			return "SIX";
		else if($hour==6)
			return "SEVEN";
		else if($hour==7)
			return "EIGHT";
		else if($hour==8)
			return "NINE";
		else if($hour==9)
			return "TEN";
		else if($hour==10)
			return "ELEVEN";
		else if($hour==11)
			return "TWELVE";
		else if($hour==12)
			return "ONE";


	}


	else{
		if($hour==1)

			return "ONE";
		else if($hour==2)
			return "TWO";
		else if($hour==3)
			return "THREE";
		else if($hour==4)
			return "FOUR";
		else if($hour==5)
			return "FIVE";
		else if($hour==6)
			return "SIX";
		else if($hour==7)
			return "SEVEN";
		else if($hour==8)
			return "EIGHT";
		else if($hour==9)
			return "NINE";
		else if($hour==10)
			return "TEN";
		else if($hour==11)
			return "ELEVEN";
		else if($hour==12)
			return "TWELVE";


	}	

}


function numberToWordMin($min)  //Function to convert minutes in digits to words
{


	if($min>0 && $min<=5)

		return "FIVE PAST";
	else if($min>5 && $min<=10)
		return "TEN PAST";
	else if($min>10 && $min<=15)
		return "QUARTER PAST";
	else if($min>15 && $min<=20)
		return "TWENTY PAST";
	else if($min>20 && $min<=25)
		return "TWENTY-FIVE PAST";
	else if($min>25 && $min<=30)
		return "HALF PAST";
	else if($min>30 && $min<=35)
		return "TWENTY-FIVE TO";
	else if($min>35 && $min<=40)
		return "TWENTY TO";
	else if($min>40 && $min<=45)
		return "QUARTER TO";
	else if($min>45 && $min<=50)
		return "TEN TO";
	else if($min>50 && $min<55)
		return "FIVE TO";




}

function pharse($min) 
{
	if(($min>0&&$min<=3)||($min>5&&$min<=8)||($min>10&&$min<=13)||($min>15&&$min<=18)||($min>20&&$min<=23)||($min>25&&$min<=28))
	{
		$myVars= array( 'ALMOST', 'ABOUT');
		srand((float)microtime() * 10000);
		shuffle($myVars);
		return $myVars[0];
	}
	elseif(($min>3&&$min<5)||($min>8&&$min<10)||($min>13&&$min<15)||($min>18&&$min<20)||($min>23&&$min<25)||($min>28&&$min<30))
	{
		$myVars= array('NEARLY', 'AROUND', 'GOING TO BE');
		srand((float)microtime() * 10000);
		shuffle($myVars);
		return $myVars[0];
	}

	elseif(($min>30 && $min<=33)||($min>35 && $min<=38)||($min>40 && $min<=43)||($min>45 && $min<=48)||($min>50 && $min<=53)||($min>55 && $min<=58))
	{
		$myVars= array('ALMOST', 'NEARLY');
		srand((float)microtime() * 10000);
		shuffle($myVars);
		return $myVars[0];
	}

	elseif(($min>33 && $min<35)||($min>38 && $min<40)||($min>43 && $min<45)||($min>48 && $min<50)||($min>53 && $min<55)||($min>58 && $min<60))
	{
		$myVars= array('ABOUT','RIGHT ABOUT','GOING TO BE');
		srand((float)microtime() * 10000);
		shuffle($myVars);
		return $myVars[0];
	}

	elseif($min==0||$min==5||$min==10||$min==15||$min==20||$min==25||$min==30||$min==35||$min==40||$min==45||$min==50||$min==55||$min==60)
	{
		$myVars= array(' ', 'NOW', 'EXACTLY','PRESICELY');
		srand((float)microtime() * 10000);
		shuffle($myVars);
		return $myVars[0];
	}
}


$hour = numberToWord(date('h'));
$min=date('i');
$minw = numberToWordMin($min);

?>

<div id="clock">
	<?php $word = pharse($min);?>
<?php echo "IT'S ".$word." <br /> ".$minw." <br />".$hour;?>


</div>


</body>
</html>
