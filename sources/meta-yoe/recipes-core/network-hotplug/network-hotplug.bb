DESCRIPTION = "Network Hotplug"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r2"

SRC_URI = " \
           file://network@.service \
           file://network.rules \
          "

FILES:${PN} = "${sysconfdir}/udev/rules.d/* ${base_libdir}/systemd/system/*"
RDEPENDS:${PN} = "udev"

do_install() {
    install -d ${D}${base_libdir}/systemd/system/basic.target.wants
    install -m 0644 ${UNPACKDIR}/*.service ${D}${base_libdir}/systemd/system

    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${UNPACKDIR}/network.rules ${D}${sysconfdir}/udev/rules.d/network.rules
}

