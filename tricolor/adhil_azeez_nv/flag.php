<?php
/*
 * Filename: tricolor.php
 * Dependencies: GD Library mostly precombile with php 4.0+
 * Author: Adhil Azeez NV
 * Description: Generates Indian National Flag Image
 */

//Create a resource identifier for the image res in ration 3:2
$flag = imagecreate(1350, 900); 
if (!$flag) {
    die("Some error occured");
}
//Color identifiers definitions
$white = imagecolorallocate($flag, 255, 255, 255);
$saffron = imagecolorallocate($flag, 255, 153, 51);
$green = imagecolorallocate($flag, 18, 136, 7);
$blue = imagecolorallocate($flag, 00, 0, 137);

//Draw the tricolor sections.The white portion is no need to be specified since
//the background color is white.
imagefilledrectangle($flag, 0, 0, 1350, 300, $saffron);
imagefilledrectangle($flag, 0, 600, 1350, 900, $green);

//Draw the Ashoka Chakra
//The Circle can be created with imageellipse itself after setting the thickness.
//But unfortunetly due to a bug in GD library(reported more than 5 years ago :()
//the thickness is being ignored.
imagefilledellipse($flag, 675, 450, 240, 240, $blue);
imagefilledellipse($flag, 675, 450, 210, 210, $white);

//Draw the center small circle
imagefilledellipse($flag, 675, 450, 42, 42, $blue);

for ($angle = 0; $angle <= 360; $angle = $angle + 15) {

//Draw 24 small circles in the Ashoka Chakra at the border of the circle adjacent
// to 24-spoke
    $x = 675 + 105 * cos(deg2rad($angle+7.5));
    $y = 450 + 105 * sin(deg2rad($angle+7.5));
    imagefilledellipse($flag, $x, $y, 10.5, 10.5, $blue);

//Draw the 24 spooks
    $x1 = 675 + 8 * cos(deg2rad($angle));
    $y1 = 450 + 8 * sin(deg2rad($angle));
    $x2 = $x1 + 40 * cos(deg2rad($angle - 5));
    $y2 = $y1 + 40 * sin(deg2rad($angle - 5));
    $x3 = 675 + 105 * cos(deg2rad($angle));
    $y3 = 450 + 105 * sin(deg2rad($angle));
    $x4 = $x1 + 40 * cos(deg2rad($angle + 5));
    $y4 = $y1 + 40 * sin(deg2rad($angle + 5));
    imagefilledpolygon($flag, array($x1, $y1, $x2, $y2, $x3, $y3,$x4,$y4), 4, $blue);
}
//if the script being invocked from CLI and has a filename arguments then write
//the out put to the file else print to the outputstream.
if (isset($_SERVER['argv'][1])) {
    if(imagejpeg($flag, $_SERVER['argv'][1] . '.jpg', 100))
    	echo "National Flag saved to ".$_SERVER['argv'][1] . '.jpg';
    else
    	echo "Some error occured";
} else {
    header("Content-type: image/jpeg");
    imagejpeg($flag, null, 100);
}
imagedestroy($flag);
?>