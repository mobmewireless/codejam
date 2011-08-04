<?php
$fp1 = fopen("input.txt", "r");

while(!feof($fp1))
{
$x=fgets($fp1);
$f=substr($x,0,1);

switch($f){
	case 0:	$nfp = fopen("0.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	case 1:	$nfp = fopen("1.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	case 2:	$nfp = fopen("2.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	case 3:	$nfp = fopen("3.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	case 4:	$nfp = fopen("4.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	case 5:	$nfp = fopen("5.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	case 6:	$nfp = fopen("6.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	case 7:	$nfp = fopen("7.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	case 8:	$nfp = fopen("8.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	case 9:	$nfp = fopen("9.txt", "a");
			fwrite($nfp, $x);
			fclose($nfp);
			break;
	}
}

fclose($fp1);
?>