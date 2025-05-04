DESCRIPTION="recipe(.bb) file for hello c example"
LICENSE="CLOSED"

SRC_URI="file://hello.c \
	file://world.cpp \
"

S="${WORKDIR}"

do_compile(){
	cd ${S}
	${CC} ${LDFLAGS} hello.c -o hello
	${CXX} ${LDFLAGS} world.cpp -o world
}
do_install(){
	install -d ${D}/usr/bin
	install -m 777 ${S}/hello  ${D}/usr/bin
	install -m 777 ${S}/world  ${D}/usr/bin
}

PACKAGES +="hello-c hello-cpp"

FILES_hello-c += "/usr/bin/hellc "
FILES_hello-cpp ="/usr/bin/world"
