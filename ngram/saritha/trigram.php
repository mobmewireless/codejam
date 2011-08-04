<?php

	$sentence=$_POST['sentence']; 
	$trigram = array();
	$words = explode(" ", $sentence);
	$len=count($words);
	$a=0;
	$b=1;
	$c=2;
	for($i=0;$i<$len-2;$i++)
	{
		$trigram[$i]=$words[$a]." ".$words[$b]." ".$words[$c];
		$a++;
		$b++;
		$c++;
	}	
	$len_trigram=count($trigram);

if($_POST['Generate_Story'])
{
	$random_trigram=$_POST['listTriagrams'];
	for($i=$random_trigram;$i<300;$i++)
	$final_story=$final_story." ".$words[$i];
}
?>

<form name="form1" method="post" action="">
  <p>Type Text Here<br>
    <textarea name="sentence" cols="60" rows="10" id="sentence"><?php echo $sentence; ?></textarea>
    </label> 
    <br>
    <input name="Generate_Trigrams" type="submit" id="Generate_Trigrams" value="Generate Triagram">
    <br>
    <br>
	<?php
	if($_POST['Generate_Trigrams'])
	{
	?>
	  Generated Trigrams <br>
	  (Select Any Trigram to generate Story) <br>
	  <select name="listTriagrams" size="10" id="listTriagrams">
		<?php
	  for($i=0;$i<=$len_trigram;$i++)
	  {
	  echo "<option value=$i>$trigram[$i]</option>";
	  }
	  ?>
	  </select>
	  <br>
	  <input name="Generate_Story" type="submit" id="Generate_Story" value="Generate Story">
  <?php 
  } 
  ?>
  </p>
  <p><br>
  <?php
	if($_POST['Generate_Story'])
	{
	?>
		 Final Generated Short Story </p>
		<div style="border:solid; border-width:1px; background-color:#FFFFCC; color:#990000"><br>
		<?php echo $final_story; 
  	} 
  ?><p>
</div><br>
</form>

<?php
//freeing memory space used for arrays
unset($trigram);
unset($words);
?>
