#!/bin/bash
#
# CBrew and Native installer script
# Provide the path of java.library.path as the first argument. This is the location
# where the native binaries will be installed.

################################## BEGIN SCRIPT #####################################

# Check if argument for java.library.path is empty. If empty, the current directory
# is set as the value.
path=${1:-.}
# Print path of java.library.path.
echo Provided Path = $path
# Clone the JBrew project libary.
git clone -b master https://github.com/nealkumar/JBrew.git/
# Extract binaries from the clone and copy it to specified location.
cp -R JBrew/bin/ $path 
# Removes the rest of clone + child directories.
sudo rm -R JBrew/
# Clean up complete. Check if install is successfull
if [ -d "$path/bin" ]; then 
	echo "Install successfull! Below you will see the binaries installed."	
else echo "Installation failure. Please consult documentation and try again."
fi
# Lists all of the path directory's contents.
ls -a $path/bin
