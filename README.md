# lein-sassy
Use Sass with Clojure.

## Prerequisites
lein-sassy uses JRuby, so you need to have Ruby installed. You probably already
do, though. JRuby is also why the plugin should only be used as a development
dependency, since you would always depend on it otherwise.

## Usage
Add the plugin to your `project.clj` only as development dependency:

[![Clojars Project](http://clojars.org/lein-sassy/latest-version.svg)](http://clojars.org/lein-sassy)

Then add the following, using your CSS folders as appropriate.
```clojure
:sass {:src "resources/app/stylesheets"
       :dst "resources/public/stylesheets"}
```

To compile files once, use `lein sass once`.

To watch files for changes, use `lein sass watch`.

## What to do if it doesn't work
If you have any trouble using lein-sassy, especially if there are any Ruby
issues, please [open an issue](https://github.com/vladh/lein-sassy/issues/new).
This helps me out a lot, as I can get feedback from people using various
platforms in order to make lein-sassy better.

## To do
* Add Autoprefixer support.
* Add more integration tests.

## Credits and License
This plugin was greatly inspired by
[lein-haml-sass](https://github.com/rtircher/lein-haml-sass).

Copyright Vlad-Ștefan Harbuz and distributed under the Eclipse Public
License, the same as Clojure.
