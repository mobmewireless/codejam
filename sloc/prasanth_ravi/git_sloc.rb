
puts "-------------------------------------"


print "Enter the Git repository:"
git_url=gets
git_url.chomp!

system ("git clone #{git_url}")
dir=git_url.match(/[\w_-]*?.git$/).to_s
print dir[0..dir.length-5]
#if File.exist?(dir)
Files=Dir.glob("./#{dir[0..dir.length-5]}/**/*.{rb,py,js,java,css,c,cpp,htm,html}")

#else
#  print"error"
#  exit(0)
#end
#single comment hash
s_cmm={ 
  "rb"=>"#",
  "py"=>"#",
  "jv"=>"//",
  "c"=>"//",
  "php1"=>"//",
  "php2"=>"#",
  "js"=>"//",
}


def count_lines(fl,type,s_cmm)
count=0
  str=IO.read(fl.to_s)

  #remove multi line comments
if %w[c cpp css js php java].include?(type)
 str.gsub!(/\/\*[.\s\S]*?\*\//,"\n")
elsif type="rb"
  str.gsub!(/=begin[\s\S]*?=end/,"\n")
elsif type="py"
  str.gsub!(/"""[\s\S]*?"""/,"\n")
elseif %w[htm html].include?(type)
   str.gsub!(/<!--[\s\S]*?-->/,"\n")
end

str=str.split(/\n/)

#remove single line comments
str.each  do |line|
  if type=="php"
    if    line =~ /^#{s_cmm["php1"]}.*/
    elsif line =~ /^ *#{s_cmm["php1"]}.*/
    elsif line =~ /^#{s_cmm["php2"]}.*/
    elsif line =~ /^ *#{s_cmm["php2"]}.*/  
    elsif line =~ /^[\t\n]$/
    elsif line =~ /.+/
      count=count+1
    end
  elsif %w[htm html].include?(type)
    
  else
    if    line =~ /^#{s_cmm[type]}.*/
    elsif line =~ /^ *#{s_cmm[type]}.*/
    elsif line =~ /^[\t\n]$/ 
    elsif line =~ /.+/
      count=count+1
    end
  end
end
  
count
end




# Ruby Count
Files.each do |fl|
  count=count_lines(fl,File.extname(fl)[1..2],s_cmm)
  print "#{fl} has #{count} lines \n"
end




  