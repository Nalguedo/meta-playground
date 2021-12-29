inherit core-image

DESCRIPTION = "A small playground image using recipes for shared lib and another to consume it"

#IMAGE_INSTALL += "libhello hello"

CORE_IMAGE_EXTRA_INSTALL = "libhello hello"
