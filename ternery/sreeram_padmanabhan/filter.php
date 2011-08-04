<?
function func($number) {
$digit=substr($number,-10,1);
$File = $digit.".txt"; 
$Handle = fopen($File, 'a');
$Data = $number."
"; 
fwrite($Handle, $Data); 
fclose($Handle);
}
?>
