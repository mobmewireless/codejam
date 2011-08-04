<?php

include_once 'scripts/functions.php';
$im1 = isset($_REQUEST['image1']) ? $_REQUEST['image1'] : '';
$im2 = isset($_REQUEST['image2']) ? $_REQUEST['image2'] : '';

if ($im1 != '' && $im2 != '') {
    $diff = imageCompare($im1, $im2);
    neat_r($diff);
}
?>