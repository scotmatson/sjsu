################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../hw08/getch.c \
../hw08/getop.c \
../hw08/hw8.c \
../hw08/main.c \
../hw08/stack.c 

OBJS += \
./hw08/getch.o \
./hw08/getop.o \
./hw08/hw8.o \
./hw08/main.o \
./hw08/stack.o 

C_DEPS += \
./hw08/getch.d \
./hw08/getop.d \
./hw08/hw8.d \
./hw08/main.d \
./hw08/stack.d 


# Each subdirectory must supply rules for building sources it contributes
hw08/%.o: ../hw08/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


