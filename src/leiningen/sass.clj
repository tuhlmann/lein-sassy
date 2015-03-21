(ns leiningen.sass
  (:require [leiningen.lein-sassy.renderer :refer :all]
            [leiningen.lein-sassy.options :refer :all]
            [leiningen.help :as lhelp]
            [leiningen.core.main :as lmain]
            [cemerick.pomegranate :only [add-dependencies]]))

(defn- once
  "Compile files once."
  [container runtime options]
  (render-all! container runtime options))

(defn- watch
  "Automatically recompile when files are modified."
  [container runtime options]
  (render-all! container runtime options)
  (watch-and-render! container runtime options))

(defn sass
  {:help-arglists '[[once] [watch]]
   :subtasks [#'once #'watch]
   :doc "Compile Sass files."}

  ([project]
    ((resolve 'leiningen.core.main/abort) (lhelp/help-for "sass")))

  ([project subtask & args]
    (if-let [options (get-sass-options project)]
      (let [{container :container runtime :runtime} (init-renderer options)]
        (case subtask
          "once" (once container runtime options)
          (or "auto" "watch") (watch container runtime options)
          (lmain/warn subtask " not found.")))
      ((resolve 'leiningen.core.main/abort) "Invalid options in project.clj."))))
