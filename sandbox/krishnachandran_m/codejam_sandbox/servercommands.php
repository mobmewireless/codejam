<?php

include_once 'scripts/functions.php';
$cmd = isset($_REQUEST['cmdbox']) ? $_REQUEST['cmdbox'] : '';
if ($cmd == '')
    exit();
$parts = explode(" ", $cmd);
//neat_r($parts);
switch ($parts[0]) {
    case 'list':
        $dir = getcwd();
        $files = array_filter(scandir($dir), "is_file");
        $fold = array_filter(scandir($dir, 1), "is_dir");
        array_pop($fold);
        array_pop($fold);
        rsort($files);
        echo "\tFiles";
        neat_r($files);
        rsort($fold);
        echo "\tFolders";
        neat_r($fold);
        break;
    case 'pwd':
        echo getcwd();
        break;
    case 'cat':
        if (!isset($parts[1]))
            echo 'Invalid Paramenter(File)';
        else if (is_file($parts[1])) {
            $file_handler = fopen($parts[1], "r");
            $contents = fread($file_handler, filesize($parts[1]));
            fclose($file_handler);
            echo "\n" . $contents;
        }
        else
            echo 'Invalid Paramenter(File). No such file exsists!';
        break;
    case 'rm':
        if (!isset($parts[1]))
            echo 'Invalid Paramenter(File)';
        else {
            if (is_file($parts[1]))
                unlink($parts[1]);
            else
                echo 'Invalid Paramenter(File). No such file exsists!';
        }
        break;
    case 'touch':
        if (!isset($parts[1]))
            echo 'Invalid Paramenter(File)';
        else {
            $cont = isset($parts[2]) ? $parts[2] : '';
            $fp = fopen($parts[1], 'w');
            fwrite($fp, $cont);
            fclose($fp);
        }
        break;
    case 'time':
        echo date('l jS \of F Y h:i:s A');
        break;
    case 'nfile':
        $fp = fopen(mt_rand() . '.tim', 'w');
        fwrite($fp, date('l jS \of F Y h:i:s A'));
        fclose($fp);
        break;
    case 'help':
        echo "list - Lists all the files in the directory the server is running on.
pwd - Print the path of the directory the server is running on.
cat &lt;filename&gt; - Print the contents of the filename given as argument.
rm &lt;filename&gt; - Delete the filename given as argument.
touch &lt;filename&gt; &lt;content&gt; - Create a file with name and content given as argument.
time - Returns the current time on the server.";
        break;
    default : echo 'Invalid Command';
}
/*
  //LIST FILES
  $dir = getcwd();
  $files = array_filter(scandir($dir), "is_file");
  $fold = array_filter(scandir($dir, 1), "is_dir");
  array_pop($fold);
  array_pop($fold);
  rsort($files);
  neat_r($files);
  rsort($fold);
  neat_r($fold);

  //PATH TO DIRECTORY
  echo getcwd();

  //CREATE FILE
  $fp = fopen('data.txt', 'w');
  fwrite($fp, '1');
  fwrite($fp, '23');
  fclose($fp);

  //PRINT FILE CONTENTS
  $file = 'data.txt';
  $file_handler = fopen($file, "r");
  $contents = fread($file_handler, filesize($file));
  fclose($file_handler);
  echo "<br/>" . $contents;

  //DELETE FILE
  unlink($file);

  //TIME
  echo date('l jS \of F Y h:i:s A');

  //RANDOM FILENAME
  //echo rand();
  echo mt_rand(); */
?>