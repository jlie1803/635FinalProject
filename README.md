# seis635-tp1
Team project one for SEIS 635

Collaborators:

- Esten Rye
- Jie Li

# Contributor Workflow.

Start from the master branch and pull latest from origin.

```bash
git checkout master
git pull
```

Next create a new branch.

```bash
git checkout -b 'my-new-branch-name'
```

On your initial push to origin, you will need to set your upstream branch.  If you do a `git push` Git will remind you of this.

```bash
git push --set-upstream origin 'my-new-branch-name'
```

After this point you can push changes to the remote repository using the following commands:

```bash
git add *
git commit -m 'your commit message'
git push
```

Every time you push, GitHub will run the CI workflow and validate your code builds and the unit tests pass.

When you are ready to merge to master, you will need to open a pull request in GitHub.