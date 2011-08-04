<?php

function neat_r($arr, $return = false) {
    $out = array();
    $oldtab = "    ";
    $newtab = "  ";
    $lines = explode("\n", print_r($arr, true));
    foreach ($lines as $line) {
        if (substr($line, -5) != "Array") {
            $line = preg_replace("/^(\s*)\[[0-9]+\] => /", "$1", $line, 1);
        }
        foreach (array("Array" => "", "[" => "", "]" => "", " =>" => ":",) as $old => $new) {
            $out = str_replace($old, $new, $out);
        }
        if (in_array(trim($line), array("Array", "(", ")", "")))
            continue;
        $indent = "\n";
        $indents = floor((substr_count($line, $oldtab) - 1) / 2);
        if ($indents > 0) {
            for ($i = 0; $i < $indents; $i++) {
                $indent .= $newtab;
            }
        }
        $out[] = $indent . trim($line);
    }
    $out = implode("<br/>", $out) . "\n";
    if ($return == true)
        return $out;
    echo $out;
}
?>