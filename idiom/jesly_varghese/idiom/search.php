<?php
set_time_limit(600); 
$query = $_GET['query'];

#Will search reuters points 750
#Search wordpress points -1
#Search dictionary.com points 1000

$stored_data = file_get_contents('data');
$stored_data = explode(':',$stored_data);
$rank =1;
$i=1;

if(in_array($query,$stored_data)==1)
{
	while(1)
		{
			
		if(strcasecmp($stored_data[$i],$query)==0)
			{
				$total_score = $stored_data[$i+1];
				
				break;	
			}
		$i=$i+2;	
		}	
		
}
else
{
	$url_blogs = "http://en.search.wordpress.com/?q=".$query;					#blog search
	$url_news = "http://www.reuters.com/search?blob=".$query;					#news search
	$url_dictionary = "http://www.merriam-webster.com/dictionary/".$query;		#dictionary search

	$curl_handle_blogs = curl_init($url_blogs);
	$curl_handle_news = curl_init($url_news);
	$curl_handle_dictionary = curl_init($url_dictionary);

	$curl_multi_handle = curl_multi_init();

	curl_setopt($curl_handle_blogs, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($curl_handle_news,CURLOPT_RETURNTRANSFER,true);
	curl_setopt($curl_handle_dictionary, CURLOPT_RETURNTRANSFER, true);

	curl_multi_add_handle($curl_multi_handle,$curl_handle_blogs);
	curl_multi_add_handle($curl_multi_handle,$curl_handle_news);
	curl_multi_add_handle($curl_multi_handle,$curl_handle_dictionary);

	do {
    	curl_multi_exec($curl_multi_handle,$running);
	} while($running > 0);

	$content_blogs = curl_multi_getcontent($curl_handle_blogs);
	$content_news = curl_multi_getcontent($curl_handle_news);
	$content_dictionary = curl_multi_getcontent($curl_handle_dictionary);

#process wordpress returns
	$wordpress_grammar = '/[0-9|,]* results for/';
	preg_match($wordpress_grammar,$content_blogs,$wordpress_preg_search);
	$wordpress_preg_search = explode(' ',$wordpress_preg_search[0]);
	$wordpress_preg_search = $wordpress_preg_search[0];
	$wordpress_preg_search = str_replace(',','',$wordpress_preg_search);
	$blog_score = $wordpress_preg_search*-1;

#process reuters results
	$reuters_grammar = '/of [0-9]+/';
	preg_match($reuters_grammar,$content_news,$reuters_preg_search);
	$reuters_preg_search = explode(' ',$reuters_preg_search[0]);
	$reuters_preg_search = $reuters_preg_search[1];
	$news_score = $reuters_preg_search*750;

#dictionary search results
	$dictionary_count = stristr($content_dictionary,$query);
	$dictionary_score = $dictionary_count*1000;

	$total_score = $blog_score+$news_score+$dictionary_score;

	$store_data = $query.':'.$total_score;
}

$i=2;
while($i<count($stored_data))
		{	if($stored_data[$i]>$total_score)
				$rank++;
			$i = $i+2;	
		}		
	
echo $rank;
if(in_array($query,$stored_data)==0)
	{
		$file = fopen('data','a+');
		fwrite($file,':'.$store_data);
		fclose($file);
	}

?>