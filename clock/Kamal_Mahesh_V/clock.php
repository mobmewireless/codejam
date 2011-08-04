<?php 

$hr=date('H');								//hour
$min=date('i');							    //minute

$showmin='';$showhr='';$temp='';$meridian=0;//initialising

if ($hr>12)									//am or pm
{$hr=$hr-12;$meridian=1;}

echo ' It is  ';

switch($hr)									// text for hour
{
case '00': if ($min>=33) $showhr='one'; else $showhr='midnight';break;	
case '1':  if ($min>=33) $showhr='two'; else $showhr='one';break;
case '2':  if ($min>=33) $showhr='three' ;else $showhr='two';break;
case '3':  if ($min>=33) $showhr='four'; else $showhr='three';break;
case '4':  if ($min>=33) $showhr='five'; else $showhr='four';break;
case '5':  if ($min>=33) $showhr='six'; else $showhr='five';break;
case '6':  if ($min>=33) $showhr='seven'; else $showhr='six';break;
case '7':  if ($min>=33) $showhr='eight'; else $showhr='seven';break;
case '8':  if ($min>=33) $showhr='nine'; else $showhr='eight';break;
case '9':  if ($min>=33) $showhr='ten'; else $showhr='nine';break;
case '10': if ($min>=33) $showhr='eleven'; else $showhr='ten';break;
case '11': if ($min>=33) {if($meridian==1){$showhr='midnight';}else {$showhr='noon';}} else $showhr='eleven';break;
case '12': if ($min>=33) $showhr='one'; else $showhr='noon';break;

}
switch($meridian)
{
case '0':
		if(($hr==00 && $min>=33)|| ($hr==01 && $min<33))
		$showhr=$showhr.' after midnight.';
		else if($hr>00 && $hr<=01 && $min>=03)
		{$showhr=$showhr.' after midnight.';}
		else if (($hr<06)&&($hr>01))
		{$showhr=$showhr.' early morning.';}
		if (($hr>=6)&&($hr<=9))
		{$showhr=$showhr.' in the morning';}
		if (($hr>9)&&($hr<=11)&&($showhr!='noon'))
		{$showhr=$showhr.' before noon.';}
		if ($hr==12 && $showhr!='noon')
		$showhr=$showhr.' after noon.';
		if ($hr==12 && $min==00)
		{$showhr=' noon.';}
		break;
case '1':if($hr<=3 && $hr!=00)
		$showhr=$showhr.' after noon.';
		else if ($hr<=6)
		$showhr=$showhr.' in the evening.';
		else if($hr<=11 && $hr>6)
		{if ($hr!=11 || ($hr==11 && $min<33)){ $showhr=$showhr.' at night.';}
				}
		else if($hr==12 && $min=='00')
		$showhr=' midnight.';
		break;

}

if($min!=0)									// text for minute
{
if($min>=3 && $min<9) {$showmin='five past'; if($min<05) {$showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=8 && $min<13) {$showmin='ten past'; if($min<10) {$showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=13 && $min<18) {$showmin='quarter past'; if($min<15){ $showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=18 && $min<23) {$showmin='twenty past'; if($min<20){ $showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=23 && $min<28) {$showmin='twenty five past'; if($min<25){ $showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=28 && $min<33) {$showmin='half past'; if($min<30) {$showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=33 && $min<38) {$showmin='twenty five to'; if($min<35){ $showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=38 && $min<43) {$showmin='twenty to'; if($min<40) {$showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=43 && $min<48) {$showmin='quarter to'; if($min<45) {$showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=48 && $min<53) {$showmin='ten to'; if($min<50){ $showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=53 && $min<58) {$showmin='five to'; if($min<55) {$showmin='almost '.$showmin;}else { $showmin='already '.$showmin;}}
if($min>=58) {$showmin='almost';} if($min>00 && $min<03) {$showmin='already';}
}

echo ' '.$showmin.' '.$showhr;




?>