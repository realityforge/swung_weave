swung-weave
===========

A simple project that processes bytecode transforming methods annotated with the
annotation @RunInEDT and @RunOutsideEDT

A method annotated with @RunInEDT may be transformed into something like

  void method() {
     if (!SwingUtilities.isEventDispatchThread()) {
        SwingUtilities.invokeAndWait(new Runnable() { public void run() { method(); } );
        return;
     }

     // do method code here, guaranteed to be in EDT
  }

Installing the IDEA plugin
--------------------------

The plugin is available in JetBrains repos. To install, simply go to
"File > Settings > Plugins > Available" and select the SwungWeave plugin from the list
of available plugins and install it.

How it works
------------

For each module of the project with the SwungWeave facet, the plugin looks for a class named
org.realityforge.swung_weave.tool.Main in its classpath. If found, it scans all the classes of the
module in its main and test output directories and enhances the annotated methods using it.
