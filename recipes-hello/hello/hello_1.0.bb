DESCRIPTION = "Consume Hello world library recipe"

SECTION = "Consume hello shared library Work"

LICENSE="CLOSED"

# package dependency declaration
DEPENDS += "libhello"

SRC_URI = "file://${BPN}.c"

S = "${WORKDIR}"

do_compile() {
    ${CC} ${BPN}.c -o ${BPN} ${CFLAGS} ${LDFLAGS} -lhello
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${BPN} ${D}${bindir}
}
