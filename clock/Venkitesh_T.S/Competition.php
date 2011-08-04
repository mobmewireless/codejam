<?php
    $hr=date("G")+5;
    $min=date("i")+30;
    if($min>=60)
    {
        $min=($min%60);
        $hr++;
    }
    $ho=array("ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN","ELEVEN","TWELVE");
    $p=0;
    $z=0;
    switch($hr%12)
    {
        case 1:
            $z=0;
	    $y=$z+1;
            break;
        case 2:
            $z=1;
	    $y=$z+1;
            break;
        case 3:
            $z=2;
            $y=$z+1; 
	    break;
        case 4:
            $z=3;
            $y=$z+1;
            break;
        case 5:
            $z=4;
            $y=$z+1;
            break;
        case 6:
            $z=5;
            $y=$z+1;
            break;
        case 7:
            $z=6;
            $y=$z+1;
            break;
        case 8:
            $z=7;
            $y=$z+1;
            break;
        case 9:
            $z=8;
            $y=$z+1;
            break;
        case 10:
            $z=9;
            $y=$z+1;
            break;
        case 11:
            $z=10;
            $y=$z+1;
            break;
        case 12:
            $z=11;
            $y=1;
            break;
                
    }
    $b=array("ABOUT","AROUND","AFTER");
    $c=array("NEARLY","ALMOST");
    $a=array("NOW","PRECISELY","EXACTLY"," ");
    $i=rand(0,3);
    $j=rand(0,2);
    $k=rand(0,1);
    echo ".<br>";
    echo ".<font size=42>";
    if($min>0 && $min<3)
    echo "IT'S ".$b[$j].$ho[$z]." O'CLOCK";
    else if($min>=3 && $min<5)
    echo "IT'S ".$c[$k]." FIVE PAST".$ho[$z];
    else if($min==5)
    echo "IT'S ".$a[$i]." FIVE PAST ".$ho[$z];
    else if($min>5 && $min<8)
    echo "IT'S ".$b[$j]." FIVE PAST ".$ho[$z];
    else if($min>=8 && $min<10)
    echo "IT'S ".$c[$k]." TEN PAST ".$ho[$z];
    else if($min==10)
    echo "IT'S ".$a[$i]." TEN PAST ".$ho[$z];
    else if($min>10 && $min<13)
    echo "IT'S ".$b[$j]." TEN PAST".$ho[$z];
    else if($min>=13 && $min<15)
    echo "IT'S ".$c[$k]." QUARTER PAST".$ho[$z];
    else if($min==15)
    echo "IT'S ".$a[$i]." QUARTER PAST ".$ho[$z];
    else if($min>15 && $min<18)
    echo "IT'S ".$b[$j]." QUARTER PAST".$ho[$z];
    else if($min>=18 && $min<20)
    echo "IT'S ".$c[$k]." TWENTY PAST".$ho[$z];
    else if($min==20)
    echo "IT'S ".$a[$i]." TWENTY PAST ".$ho[$z];
    else if($min>20 && $min<23)
    echo "IT'S ".$b[$j]." TWENTY PAST".$ho[$z];
    else if($min>=23 && $min<25)
    echo "IT'S ".$c[$k]." TWENTY FIVE PAST".$ho[$z];
    else if($min==25)
    echo "IT'S ".$a[$i]." TWENTY FIVE PAST ".$ho[$z];
    else if($min>25 && $min<28)
    echo "IT'S ".$b[$j]." TWENTY FIVE PAST ".$ho[$z];
    else if($min>=28 && $min<30)
    echo "IT'S ".$c[$k]." HALF PAST ".$ho[$z];
    else if($min==30)
    echo "IT'S ".$a[$i]." HALF PAST ".$ho[$z];
    else if($min>30 && $min<33)
    echo "IT'S ".$b[$j]." HALF PAST ".$ho[$z];
    else if($min>=33 && $min<35)
    echo "IT'S ".$c[$k]." TWENTYFIVE TO ".$ho[$y];
    else if($min==35)
    echo "IT'S ".$a[$i]." TWENTY FIVE TO ".$ho[$y];
    else if($min>35 && $min<38)
    echo "IT'S ".$b[$j]." TWENTYFIVE TO ".$ho[$y];
    else if($min >=38 && $min<40)
    echo "IT'S ".$c[$k]." TWENTY TO ".$ho[$y];
    else if($min==40)
    echo "IT'S ".$a[$i]." TWENTY TO ".$ho[$y];
    else if($min>40 && $min<43)
    echo "IT'S ".$b[$j]." TWENTY TO ".$ho[$y];
    else if($min>=43 && $min<45)
    echo "IT'S ".$c[$k]." QUARTER TO ".$ho[$y];
    else if($min==45)
    echo "IT'S ".$a[$i]." QUARTER TO ".$ho[$y];
    else if($min>45 && $min<48)
    echo "IT'S ".$b[$j]." QUARTER TO ".$ho[$y];
    else if($min>=48 && $min<50)
    echo "IT'S ".$c[$k]." TEN TO ".$ho[$y];
    else if($min==50)
    echo "IT'S ".$a[$i]." TEN TO".$ho[$y];
    else if($min>50 && $min<53)
    echo "IT'S ".$b[$j]." TEN TO ".$ho[$y];
    else if($min>=53 && $min<55)
    echo "IT'S ".$c[$k]." FIVE TO ".$ho[$y];
    else if($min==55)
    echo "IT'S ".$a[$i]." FIVE TO ".$ho[$y];
    else if($min>55 && $min<58)
    echo "IT'S ".$b[$j]." FIVE TO ".$ho[$y];
    else if($min>=58 && $min<60)
    echo "IT'S ".$c[$k]." FIVE TO ".$ho[$y];
    else if($min==0)
    echo "IT'S ".$a[$i]." ".$ho[$z]."O'CLOCK"; 
?>