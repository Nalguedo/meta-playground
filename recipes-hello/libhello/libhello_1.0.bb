DESCRIPTION = "Hello world first recipe"

SECTION = "HelloWorld shared library"

LICENSE="CLOSED"

SRC_URI = "file://${BPN}.c \
    file://${BPN}.h"

S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} -shared -Wl,-soname,libhello.so.${PV} \
    -o libhello.so.${PV} -fPIC ${BPN}.c 
}

do_install() {
    install -Dm 0755 libhello.so.${PV} ${D}${libdir}/libhello.so.${PV}
    ln -sf libhello.so.${PV} ${D}${libdir}/libhello.so

    install -Dm 0644 ${BPN}.h ${D}${includedir}/${BPN}.h

    # recommended way doesn't work
    #install -d ${D}${libdir}
    #oe_soinstall libhello.so.${PV} ${D}${libdir}
}
