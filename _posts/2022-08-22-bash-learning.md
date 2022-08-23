---
toc: true
layout: post
description: Learning how to use bash.
categories: [markdown,bash]
title: Bash Learning
---
# Bash Learning
> Learning how to use bash

- toc: true 
- badges: true
- comments: true
- categories: [jupyter,bash]
# Bash script to verify project directories and projects
## Initial setup to clone
```bash
echo "Using conditional statement to create a project directory and project"


# Variable section
export project_dir=$HOME/bash_clone_test  # change vscode to different name to test git clone
export project=$testing_dir/blog  # change APCSP to name of project from git clone
export project_repo="https://github.com/supermengman/blog"  # change to project of choice

cd ~    # start in home directory

# Conditional block to make a project directory
if [ ! -d $project_dir ]
then 
    echo "Directory $project_dir does not exists... makinng directory $project_dir"
    mkdir -p $project_dir
fi
echo "Directory $project_dir exists." 

# Conditional block to git clone a project from project_repo
if [ ! -d $project ]
then
    echo "Directory $project does not exists... cloning $project_repo"
    cd $project_dir
    git clone $project_repo
    cd ~
fi
echo "Directory $project exists."
```
## Filesystem Management in Bash
### cd, pwd, echo, ls
- cd changes directory
- pwd prints working directory
- echo "echoes" lines into terminal
- ls "lists" files in directories
```bash
echo "Navigate to project, then navigate to area where files were cloned"
cd $project # Changes Directory to the project
pwd # outputs the current directory

echo "" # empty space
echo "list top level or root of files with project pulled from github"
ls # list

echo "" 
echo "list again with hidden files pulled from github"
ls -a   # hidden files flag, many shell commands have flags

echo ""
echo "list all files in long format"
ls -al   # all files and long listing

echo ""
echo "list all files in long format recursively"
ls -Ral   # all files and long listing
```
### Moving through Linux Directories
```bash
echo "Look for posts"
export posts=$project/_posts  # _posts inside project
cd $posts  # this should exist per fastpages
pwd  # present working directory
ls -l  # list posts


echo "Look for notebooks"
export notebooks=$project/_notebooks  # _notebooks is inside project
cd $notebooks   # this should exist per fastpages
pwd  # present working directory
ls -l  # list notebooks


echo "Look for images in notebooks, print working directory, list files"
cd $notebooks/images  # this should exist per fastpages
pwd
ls -l
```
### Show contents of files
```bash
echo "Navigate to project, then navigate to area where files were cloned"

cd $project
echo "show the contents of index.html"
echo ""

cat index.html  # show contents of file, in this case markdown
echo ""
echo "end of index.html"
```
# Other additional bash commands
## Commands for Permissions
- chmod is the command used to change access permissions of files (allowing specific people to read, write, or execute files)
    - permissions are in octal, meaning that a number 0-7 determines the permission for each part (usually there are 3 parts)
        - part 1 (user): changes the permission for the user that owns the file
        - part 2 (group): changes the permission for the group that owns the file (such as administrator or sudo)
        - part 3 (others): changes the permission for all users
    - numbers in chmod correspond to the permissions, adding the numbers up results in the complete permission for that part
        - 0 = no permissions, 1 = execute permission, 2 = write permission, 4 = read permission
            - ex: a permission of 6 = 4 + 2 + 0 so only read and write permissions
- chown is the command used to change ownership of files
    - easier than chmod, just specify the user and the file
- chgrp command used to change group that owns file
    - similar syntax to chown
```bash
cd $project
chmod 644 README.md # changes permissions of the README file to 644, so owner can read and write, while the group and others can only read
chown root README.md # changes owner of README.md to root
chgrp sudo README.md # changes group that has access to README.md to sudo

chown root:sudo README.md # does both owner and group at the same time
```
## Filtering Commands
grep is a very useful command in linux, used to filter content inside files to find a specific match. grep can also be used to find a match in the output of a command.
```bash
grep "the" README.md # searches for and prints any matches of "read" in readme file
grep -rl "read" $project # searches recursively through project directory for "read" while only listing filenames
```

find is a command similar to grep, but it matches filenames instead of the contents instead files or from outputs like grep does.
```bash
echo "README files"
find $project -iname *README* # finds files in the project directory that have readme in the name

echo ""
echo "jupyter notebook files"
find $project -iname *.ipynb # finds files in the project directory that have md as the file extension
```
## Miscellaneous Commands
- "env" shows environmental variables set in shell
- "sort" sorts the output or contents of a file (can set specific flags)
- "head"/"tail" outputs the first or last lines of a file
 
# Hacks
Possible bash automations:
## Verifying Installation of Tools

This is a simple bash script (a file with .sh file extension) that checks if a package is installed and installs it based on user input.
```bash
#!/bin/bash
while true;
do
    read -r -p "would you like to choose a package to check? [y/n] " option # asks and reads input of user if they want to see if package is installed
    case $option in # uses input to see the results
        y) 
        read -p "Enter package to check: " tools_verify # reads input for specific package
        if [[ $(apt list --installed $tools_verify 2>/dev/null | tail -1) = *installed* ]]; then  # checks if the tool is installed
            version_number=$(apt list --installed python3 2>/dev/null | tail -1 | cut -d " " -f 2) # finds the version number
            echo "$tools_verify is installed! The version number is $version_number."
            echo ""
        else
            while true;
            do
                read -r -p "$tools_verify is not installed! Would you like to install? [y/n] " install_option
                case $install_option in 
                    y)
                    sudo apt-get install -y $tools_verify # installs the package
                    version_number=$(apt list --installed python3 2>/dev/null | tail -1 | cut -d " " -f 2) # finds the version number
                    echo "$tools_verify is installed! The version number is $version_number."
                    echo ""
                    break # returns back to main loop of package to check
                    ;;
                    n)
                    echo "alright then!" 
                    break # returns back to main loop
                    ;;
                    *)
                    echo "Invalid Option"
                    ;;
                esac
            done
        fi
        ;;
        n)
        echo "see you next time!"
        break # ends the script
        ;;
        *)
        echo "Invalid Option" # throws user back to start of script
        ;;
    esac
done
```
## Conda Verifiying Packages Installed

This code snippet checks if a package in conda is installed, and if not, installs it.
```bash
export conda_package=jupyter # can be any package
if [[ $(conda list $conda_package) = *$conda_package* ]]; then # matches package with list of installed
    echo "$conda_package is already installed!"
else
    echo "$conda_package has not been installed, installing now."
    conda install $conda_package
fi
```
## Updating Repositories
```bash
export repository=blog # sets the repository to a specific one
export repo_main_folder=vscode # where the repositories are stored
cd $HOME/$repo_main_folder/$blog # moves into that directory
git fetch origin # fetches any changes
git pull origin master # updates the repo with new changes

```