plugins {
    id( "io.github.arc-blroth.cargo-wrapper").version( "1.2.0")
}

cargo {
    // Figure out what extension the built library will have.
    // The plugin does not do this automatically, because
    // it is possible that one might be cross-compiling, in
    // which case the operating system cannot reliably be
    // used to figure out the extension.
    //
    // This code assumes that the library will not be
    // cross-compiled, and that the default toolchain
    // according to rustup compiles for the host target.
    outputs = mapOf("" to "wrapper_example")
}