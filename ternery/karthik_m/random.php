<?php
$fp = fopen("input.txt", "a");
while(1)
{
$x=pow(mt_rand(31777,99999),2);
$x=$x."\n";
fwrite($fp, $x);
}
fclose($fp);
?>